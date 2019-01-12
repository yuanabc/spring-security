package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.annotation.validator.InsertAction;
import com.ybinsure.auth.annotation.validator.UpdateAction;
import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.constant.ChannelCode;
import com.ybinsure.auth.constant.PermissionCode;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.link.CompanyLinkWebConfig;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.param.DatongCompany;
import com.ybinsure.auth.model.transfer.tree.CompanyTreeNode;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.tool.DatongCompanyService;
import com.ybinsure.auth.service.wrap.CompanyWrapService;
import com.ybinsure.auth.util.AuthenticationHelper;
import com.ybinsure.auth.util.ValidatedResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Api(tags = "机构相关服务")
public class CompanyEndpoint {

    private final CompanyService companyService;
    private final CompanyWrapService companyWrapService;
    private final DatongCompanyService datongCompanyService;


    @DeleteMapping(ApiPath.COMPANY_DELETE)
    @PreAuthorize("hasAuthority(" + PermissionCode.companyDelete + ")")
    @ApiOperation(value = "删除机构", notes = PermissionCode.tipPrefix + PermissionCode.companyDelete)
    public Result<Boolean> delete(
            @ApiParam(value = "机构id", required = true)
            @PathVariable("id") String id
    ) {
        CompanyDO companyDO = new CompanyDO();
        companyDO.setId(id);
        if (!this.companyService.isExist(companyDO)) {
            return Result.nonError("机构不存在, ");
        }
        if (!this.companyWrapService.delete(id)) {
            return Result.nonError();
        }
        return Result.success();
    }

    @PostMapping(ApiPath.COMPANY_DISABLE)
    @PreAuthorize("hasAuthority(" + PermissionCode.companyDisable + ")")
    @ApiOperation(value = "禁用机构", notes = PermissionCode.tipPrefix + PermissionCode.companyDisable)
    public Result<Boolean> disable(
            @ApiParam(value = "机构id", required = true)
            @PathVariable("id") String id
    ) {
        CompanyDO companyDO = new CompanyDO();
        companyDO.setId(id);
        if (!this.companyService.isExist(companyDO)) {
            return Result.nonError("机构不存在, ");
        }
        if (!this.companyWrapService.disable(id)) {
            return Result.nonError();
        }
        return Result.success();
    }

    @PostMapping(ApiPath.COMPANY_RECOVERY)
    @PreAuthorize("hasAuthority(" + PermissionCode.companyDisable + ")")
    @ApiOperation(value = "恢复机构", notes = PermissionCode.tipPrefix + PermissionCode.companyDisable)
    public Result<Boolean> recovery(
            @ApiParam(value = "机构id")
            @PathVariable("id") String id
    ) {
        CompanyDO companyDO = new CompanyDO();
        companyDO.setId(id);
        if (!this.companyService.isExist(companyDO)) {
            return Result.nonError("机构不存在, ");
        }
        if (!this.companyService.recovery(id)) {
            return Result.nonError();
        }
        return Result.success();
    }

    @PostMapping(ApiPath.COMPANY_SORT)
    @ApiOperation(value = "机构排序")
    public Result<Boolean> sort(
            @ApiParam(value = "机构id", required = true)
            @RequestParam("id") String id,
            @ApiParam(value = "排序方式, 1-上移，2-下移", required = true)
            @RequestParam("sortType") String sortType
    ) {
        if (!this.companyService.sortById(id, sortType)) {
            return Result.nonError();
        }
        return Result.success();
    }

    @PostMapping(ApiPath.COMPANY_DATONG_SYNC)
    @ApiOperation(value = "大童机构同步")
    public Result<Void> datongSync(
            @ApiParam("请求数据，必要字段：comName，comGrade，province，city，comCode，upComCode")
            @Validated(InsertAction.class)
            @RequestBody()DatongCompany param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        this.datongCompanyService.sync(param);
        return Result.success();
    }

    @GetMapping(ApiPath.COMPANY_QUERY)
    @ApiOperation(value = "查询机构数据")
    public Result<CompanyDO> query(
            @ApiParam("机构id")
            @PathVariable("id") String id
    ) {
        return companyService.query(id).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.COMPANY_QUERYS)
    @ApiOperation(value = "查询多个机构数据")
    public Result<List<CompanyDO>> querys(
            @ApiParam(value = "机构id", required = true)
            @RequestBody() List<String> ids
    ) {
        if (ids.size() > 50) {
            return Result.success(new ArrayList<>());
        }
        return Result.success(companyService.querys(ids).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.COMPANY_QUERY_CHILDREN_BY_TOKEN)
    @ApiOperation(value = "查询登陆用户的机构信息")
    public Result<List<CompanyDO>> queryByToken() {
        return Result.success(companyWrapService.queryChildrenByToken().orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_BY_CODES)
    @ApiOperation(value = "根据code查询机构信息")
    public Result<List<CompanyDO>> queryByCode(
            @ApiParam(value = "机构code", required = true)
            @RequestBody() List<Long> codes
    ) {
        return Result.success(companyService.queryByCodes(codes).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.COMPANY_QUERY_ALL_WITH_TREE_OF_EFFECTIVE)
    @ApiOperation(value = "查询当前登录用户的机构权限内的机构树，不限制节点数量")
    public Result<List<TreeNode>> queryAllWithTreeOfEffective() {
        return Result.success(companyWrapService.queryAllWithTreeOfEffective().orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.COMPANY_QUERY_ALL_WITH_TREE_FILTER_BY_ID_AND_OTHER)
    @ApiOperation(value = "查询当前用户的机构权限内的机构节点，然后使用id过滤节点")
    public Result<List<TreeNode>> queryAllWithTreeFilterByIdAndOther(
            @ApiParam(value = "机构id", required = true)
            @PathVariable() String id
    ) {
        return Result.success(companyWrapService.queryAllWithTreeFilterByIdAndOther(id).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.COMPANY_QUERY_CHILDREN_BY_ID)
    @ApiOperation(value = "查询子机构信息")
    public Result<List<CompanyDO>> queryChildrenById(@PathVariable("id") String id) {
        return Result.success(companyService.queryChild(id).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.COMPANY_QUERY_COMPANY_TREE_NODE_CHILDREN_BY_ID)
    @ApiOperation(value = "查询子机构的机构树")
    public Result<List<CompanyTreeNode>> queryCompanyTreeChildrenById(
            @ApiParam(value = "机构id", required = true)
            @PathVariable("id") String id
    ) {
        List<CompanyTreeNode> result = companyService.queryChild(id).orElseGet(ArrayList::new)
                .stream()
                .map(CompanyDO::convertCompanyTreeNode)
                .collect(Collectors.toList());
        return Result.success(result);
    }

    @GetMapping(ApiPath.COMPANY_QUERY_ALL_PARENTS)
    @ApiOperation(value = "查询父节点信息")
    public Result<List<CompanyDO>> queryParent(
            @ApiParam(value = "机构id", required = true)
            @PathVariable() String id
    ) {
        return Result.success(companyService.queryAllParents(id).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_ALL_PARENTS_TREE)
    @ApiOperation(value = "查询父节点的树型结构")
    public Result<List<TreeNode>> queryParentTree(
            @ApiParam(value = "机构id", required = true)
            @RequestParam("companyId") String companyId,
            @ApiParam(value = "过滤分类，1-过滤到同保监地机构，2-过滤到悦保总部根节点")
            @RequestParam("filterType") Integer filterType
    ) {
        return Result.success(companyService.queryAllParentsTree(companyId, filterType).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_WITH_PAGE)
    @ApiOperation(value = "分页查询机构信息")
    public Result<PageResult<List<CompanyDO>>> queryWithPage(@RequestBody()PageParam<CompanyDO> pageParam) {
        return Result.success(companyService.queryWithPage(pageParam).orElseGet(PageResult::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_CHILDREN_OF_TEAM)
    @ApiOperation(value = "查询子节点中的团队机构id")
    public Result<List<String>> queryChildOfTeam(
            @ApiParam(value = "机构id")
            @PathVariable("id") String id
    ) {
        return Result.success(companyWrapService.queryChildWithTeam(id).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_CHILDREN_OF_TEAMS)
    @ApiOperation(value = "查询多个子节点中的团队机构id")
    public Result<List<String>> queryChildrenOfTeams(
            @ApiParam(value = "机构id")
            @RequestBody() List<String> ids
    ) {
        return Result.success(companyWrapService.queryChildrenWithTeam(ids).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_WITH_TREE_BY_CHANNEL)
    @ApiOperation(value = "查询渠道内的机构树")
    public Result<List<TreeNode>> queryWithTreeByChannel(
            @RequestBody() CompanyDO param
    ) {
        return Result.success(companyWrapService.queryWithTreeByChannelCode(param).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_WITH_TREE_BY_ID)
    @ApiOperation(value = "查询匹配的机构数据，机构以树型数据返回，包含子机构节点")
    public Result<List<TreeNode>> queryChildrenTreeById(
            @ApiParam(value = "机构id", required = true)
            @RequestBody() List<String> ids
    ) {
        return Result.success(companyWrapService.queryChildrenTreeFilterByIds(ids,false).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_WITH_TREE_AND_FILTER_TEAM_COMPANY_BY_ID)
    @ApiOperation(value = "查询匹配的机构数据，机构以树型数据返回，包含子机构节点，过滤团队性质的节点")
    public Result<List<TreeNode>> queryChildrenTreeAndFilterTeamCompanyByID(
            @ApiParam(value = "机构id", required = true)
            @RequestBody() List<String> ids
    ) {
        return Result.success(companyWrapService.queryChildrenTreeFilterByIds(ids,true).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_SIMPLE_INFO)
    @ApiOperation(value = "查询多个机构信息，请使用" + ApiPath.COMPANY_QUERYS)
    @Deprecated
    public Result<List<CompanyDO>> querySimpleInfo(
            @ApiParam(value = "机构id", required = true)
            @RequestBody() List<String> ids
    ) {
        return Result.success(companyService.querys(ids).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_WITH_PROVINCE_AND_CITY)
    @ApiOperation(value = "查询符合省市条件的团队结构")
    public Result<List<CompanyDO>> queryByProvinceAndCity(
            @ApiParam(value = "请求数据，必要字段：province， city，channelCode")
            @Validated(CompanyDO.QueryTeamByProvinceAndCityAndChannelCode.class)
            @RequestBody() CompanyDO param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        return Result.success(companyService.queryTeamCompanyByProvinceAndCityAndChannelCode(param).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.COMPANY_QUERY_COMPANY_TREE_OF_EFFECTIVE)
    @ApiOperation(value = "查询当前用户机构权限内的机构信息，数据以树型结构返回")
    public Result<List<CompanyDO>> queryCompanyTree() {
        return Result.success(companyWrapService.queryCompanyTreeOfEffective().orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_COMPANY_TYPE_CHILDREN_TREE_OF_EFFECTIVE)
    @ApiOperation(value = "查询多个机构的子机构，数据以树型数据返回。如果当前人员是管理渠道的人员操作则使用入参机构id,否则使用当前人员的机构权限")
    public Result<List<TreeNode>> queryCompanyTypeChildrenTreeOfEffective(
            @ApiParam(value = "机构id")
            @RequestParam(required = false) String companyId
    ) {
        List<String> currentCompanyIds = getCurrentCompanyIdWithEffective(companyId);
        return Result.success(companyWrapService.queryCompanyTypeChildrenTreeNode(currentCompanyIds).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_COMPANY_TYPE_CHILDREN_TREE)
    @ApiOperation(value = "查询多个机构的子机构，数据以树型数据返回")
    public Result<List<TreeNode>> queryCompanyTypeChildrenTree(
            @ApiParam(value = "机构id", required = true)
            @RequestBody() List<String> companyIds
    ) {
        return Result.success(companyWrapService.queryCompanyTypeChildrenTreeNode(companyIds).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_TEAM_TYPE_CHILDREN_TREE_WITH_SALES_OF_EFFECTIVE)
    @ApiOperation(value = "查询机构的团队子机构和团队子机构的业务员，数据以树型数据返回。如果当前人员是管理渠道的人员操作则使用入参机构id,否则使用当前人员的机构权限")
    public Result<List<TreeNode>> queryTeamTypeChildrenTreeOfEffective(
            @ApiParam(value = "机构id")
            @RequestParam(required = false) String companyId
    ) {
        List<String> currentCompanyIds = getCurrentCompanyIdWithEffective(companyId);
        return Result.success(companyWrapService.queryTeamTypeChildrenAndSalesTreeNode(currentCompanyIds).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_TEAM_TYPE_CHILDREN_TREE_WITH_SALES)
    @ApiOperation(value = "查询多个机构的团队子机构和团队子机构的业务员，数据以树型数据返回")
    public Result<List<TreeNode>> queryTeamTypeChildrenTree(
            @ApiParam(value = "机构id", required = true)
            @RequestBody() List<String> companyIds
    ) {
        return Result.success(companyWrapService.queryTeamTypeChildrenAndSalesTreeNode(companyIds).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_PARENTS)
    @ApiOperation(value = "查询多个机构的父级机构")
    public Result<Map<String, List<CompanyDO>>> queryParents(
            @ApiParam(value = "机构id", required = true)
            @RequestBody() List<String> ids
    ) {
        return Result.success(companyWrapService.queryParent(ids).orElseGet(HashMap::new));
    }

    @PostMapping(ApiPath.COMPANY_EXIST)
    @ApiOperation(value = "检查机构是否存在")
    public Result<Boolean> exist(
            @ApiParam(value = "请求数据，必要字段：id或者oldCode/channelCode", required = true)
            @RequestBody() CompanyDO param
    ) {
        return Result.success(companyService.isExist(param));
    }

    private List<String> getCurrentCompanyIdWithEffective(String param) {
        String channelCode = AuthenticationHelper.localContextHolderParser().getChannelCode().orElseThrow(FailResultException::userInfoError);
        // 管理员账号使用入参机构信息，否则使用当前用户的机构信息
        if (ChannelCode.isAnyAdminChannel(channelCode)) {
            return Optional.ofNullable(param).map(Arrays::asList).orElseThrow(() -> new FailResultException("管理员渠道需要入参机构信息"));
        } else {
            return AuthenticationHelper.localContextHolderParser().getCompanyAuthority();
        }
    }

    @PostMapping(ApiPath.COMPANY_LINK_WEB_CONFIG_INSERT)
    @PreAuthorize("hasAuthority(" + PermissionCode.companyInsert + ")")
    @ApiOperation(value = "新增机构以及机构配置信息", notes = PermissionCode.tipPrefix + PermissionCode.companyInsert)
    public Result<String> insertCompanyLinkWebConfig(
            @ApiParam(value = "请求数据，必要数据：companyDO.name, companyDO.companyType, companyDO.province, companyDO.city, companyDO.parentId, companyDO.level, companyDO.channelCode, companyDO.deleted, companyDO.status, webConfigDOS.code, webConfigDOS.value")
            @Validated({InsertAction.class})
            @RequestBody() CompanyLinkWebConfig param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        CompanyDO company = new CompanyDO();
        company.setOldCode(param.getCompanyDO().getOldCode());
        company.setChannelCode(param.getCompanyDO().getChannelCode());
        if (companyService.isExist(company)) {
            return Result.nonError("该机构编码已经存在，");
        }
        return companyWrapService.insertCompanyLinkWebConfig(param).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.COMPANY_LINK_WEB_CONFIG_UPDATE)
    @PreAuthorize("hasAuthority(" + PermissionCode.companyEdit + ")")
    @ApiOperation(value = "更新机构以及机构配置信息", notes = PermissionCode.tipPrefix + PermissionCode.companyEdit)
    public Result<Boolean> updateCompanyLinkWebConfig(
            @ApiParam(value = "请求数据, 必要数据：id", required = true)
            @Validated({UpdateAction.class})
            @RequestBody() CompanyLinkWebConfig param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (!companyWrapService.updateCompanyLinkWebConfig(param)) {
            return Result.nonError();
        }
        return Result.success();
    }

}
