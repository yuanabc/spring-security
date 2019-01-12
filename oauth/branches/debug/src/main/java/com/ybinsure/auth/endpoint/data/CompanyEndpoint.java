package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.annotation.InsertAction;
import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.constant.ChannelCode;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.param.DatongCompany;
import com.ybinsure.auth.model.transfer.tree.CompanyTreeNode;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.service.adapter.CompanyAdapterService;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.tool.DatongCompanyService;
import com.ybinsure.auth.service.wrap.CompanyWrapService;
import com.ybinsure.auth.util.AuthenticationHelper;
import com.ybinsure.auth.util.ValidatedResultUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CompanyEndpoint {

    private final CompanyService companyService;
    private final CompanyWrapService companyWrapService;
    private final CompanyAdapterService companyAdapterService;
    private final DatongCompanyService datongCompanyService;


    @DeleteMapping(ApiPath.COMPANY_DELETE)
    public Result<Boolean> delete(@PathVariable("id") String id) {
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
    public Result<Boolean> disable(@PathVariable("id") String id) {
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
    public Result<Boolean> recovery(@PathVariable("id") String id) {
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

    @PostMapping(ApiPath.COMPANY_DATONG_SYNC)
    public Result<Void> datongSync(
            @Validated(InsertAction.class) @RequestBody()DatongCompany param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        this.datongCompanyService.sync(param);
        return Result.success();
    }

    @GetMapping(ApiPath.COMPANY_QUERY)
    public Result<CompanyDO> query(@PathVariable("id") String id) {
        return companyService.query(id).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.COMPANY_QUERYS)
    public Result<List<CompanyDO>> querys(@RequestBody() List<String> ids) {
        if (ids.size() > 50) {
            return Result.success(new ArrayList<>());
        }
        return Result.success(companyService.querys(ids).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.COMPANY_QUERY_CHILDREN_BY_TOKEN)
    public Result<List<CompanyDO>> queryByToken() {
        return Result.success(companyWrapService.queryChildrenByToken().orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_BY_CODES)
    public Result<List<CompanyDO>> queryByCode(@RequestBody() List<Long> codes) {
        return Result.success(companyService.queryByCodes(codes).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.COMPANY_QUERY_ALL_WITH_TREE_OF_EFFECTIVE)
    public Result<List<TreeNode>> queryAllWithTreeOfEffective() {
        return Result.success(companyAdapterService.queryAllWithTreeOfEffectiveNotLimit().orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_ALL_WITH_TREE_OF_EFFECTIVE_BY_IDS)
    public Result<List<TreeNode>> queryAllWithTreeOfEffectiveByIds(@RequestBody() List<String> ids) {
        return Result.success(companyAdapterService.queryAllWithTreeOfEffective(ids).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.COMPANY_QUERY_ALL_WITH_TREE_FILTER_BY_ID_AND_OTHER)
    public Result<List<TreeNode>> queryAllWithTreeFilterByIdAndOther(@PathVariable() String id) {
        return Result.success(companyAdapterService.queryAllWithTreeFilterByIdAndOther(id).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.COMPANY_QUERY_CHILDREN_BY_ID)
    public Result<List<CompanyDO>> queryChildrenById(@PathVariable("id") String id) {
        return Result.success(companyService.queryChild(id).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.COMPANY_QUERY_COMPANY_TREE_NODE_CHILDREN_BY_ID)
    public Result<List<CompanyTreeNode>> queryCompanyTreeChildrenById(@PathVariable("id") String id) {
        List<CompanyTreeNode> result = companyService.queryChild(id).orElseGet(ArrayList::new)
                .stream()
                .map(CompanyDO::convertCompanyTreeNode)
                .collect(Collectors.toList());
        return Result.success(result);
    }

    @GetMapping(ApiPath.COMPANY_QUERY_ALL_PARENTS)
    public Result<List<CompanyDO>> queryParent(@PathVariable() String id) {
        return Result.success(companyService.queryAllParents(id).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_ALL_PARENTS_TREE)
    public Result<List<TreeNode>> queryParentTree(@RequestParam("companyId") String companyId, @RequestParam("filterType") Integer filterType) {
        return Result.success(companyService.queryAllParentsTree(companyId, filterType).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_WITH_PAGE)
    public Result<PageResult<List<CompanyDO>>> queryWithPage(@RequestBody()PageParam<CompanyDO> pageParam) {
        return Result.success(companyService.queryWithPage(pageParam).orElseGet(PageResult::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_CHILDREN_OF_TEAM)
    public Result<List<String>> queryChildOfTeam(@PathVariable("id") String id) {
        return Result.success(companyAdapterService.queryChildWithTeam(id).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_CHILDREN_OF_TEAMS)
    public Result<List<String>> queryChildrenOfTeams(@RequestBody() List<String> param) {
        return Result.success(companyAdapterService.queryChildrenWithTeam(param).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_WITH_TREE_BY_CHANNEL)
    public Result<List<TreeNode>> queryWithTreeByChannel(@RequestBody() CompanyDO param) {
        return Result.success(companyAdapterService.queryWithTreeByChannelCode(param).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_WITH_TREE_BY_ID)
    public Result<List<TreeNode>> queryWithTreeByChannel(@RequestBody() List<String> param) {
        return Result.success(companyAdapterService.queryWithTree(param).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_SIMPLE_INFO)
    public Result<List<CompanyDO>> querySimpleInfo(@RequestBody() List<String> ids) {
        return Result.success(companyService.querySimpleInfo(ids).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_WITH_PROVINCE_AND_CITY)
    public Result<List<CompanyDO>> queryByProvinceAndCity(
            @Validated(CompanyDO.QueryByProvinceAndCity.class) @RequestBody() CompanyDO param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        return Result.success(companyService.queryByProvinceAndCity(param).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.COMPANY_QUERY_COMPANY_TREE_OF_EFFECTIVE)
    public Result<List<CompanyTreeNode>> queryCompanyTree() {
        return Result.success(companyAdapterService.queryCompanyTreeOfEffective().orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_COMPANY_TYPE_CHILDREN_TREE_OF_EFFECTIVE)
    public Result<List<TreeNode>> queryCompanyTypeChildrenTreeOfEffective(@RequestParam(required = false) String companyId) {
        List<String> currentCompanyIds = getCurrentCompanyIdWithEffective(companyId);
        return Result.success(companyAdapterService.queryCompanyTypeChildrenTreeNode(currentCompanyIds).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_COMPANY_TYPE_CHILDREN_TREE)
    public Result<List<TreeNode>> queryCompanyTypeChildrenTree(@RequestBody() List<String> companyIds) {
        return Result.success(companyAdapterService.queryCompanyTypeChildrenTreeNode(companyIds).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_TEAM_TYPE_CHILDREN_TREE_WITH_SALES_OF_EFFECTIVE)
    public Result<List<TreeNode>> queryTeamTypeChildrenTreeOfEffective(@RequestParam(required = false) String companyId) {
        List<String> currentCompanyIds = getCurrentCompanyIdWithEffective(companyId);
        return Result.success(companyAdapterService.queryTeamTypeChildrenAndSalesTreeNode(currentCompanyIds).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_TEAM_TYPE_CHILDREN_TREE_WITH_SALES)
    public Result<List<TreeNode>> queryTeamTypeChildrenTree(@RequestBody() List<String> companyIds) {
        return Result.success(companyAdapterService.queryTeamTypeChildrenAndSalesTreeNode(companyIds).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.COMPANY_QUERY_PARENTS)
    public Result<Map<String, List<CompanyDO>>> queryParents(@RequestBody() List<String> ids) {
        return Result.success(companyAdapterService.queryParent(ids).orElseGet(HashMap::new));
    }

    @PostMapping(ApiPath.COMPANY_EXIST)
    public Result<Boolean> exist(@RequestBody() CompanyDO param) {
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

}
