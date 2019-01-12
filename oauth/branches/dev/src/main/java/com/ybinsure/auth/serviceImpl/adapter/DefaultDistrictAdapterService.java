package com.ybinsure.auth.serviceImpl.adapter;

import com.ybinsure.auth.constant.CacheKey;
import com.ybinsure.auth.constant.DistrictLevelCode;
import com.ybinsure.auth.model.data.DistrictDO;
import com.ybinsure.auth.model.transfer.tree.DistrictTreeOption;
import com.ybinsure.auth.service.adapter.DistrictAdapterService;
import com.ybinsure.auth.service.data.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultDistrictAdapterService implements DistrictAdapterService {

    private final DistrictService districtService;

    @Override
    @Cacheable(value = CacheKey.districtQueryTreeWithProvinceAndCity)
    public List<DistrictTreeOption> queryTreeWithProvinceAndCity() {
        List<DistrictDO> provinceAndCity = districtService.queryProvinceAndCity().orElseGet(ArrayList::new);
        return convertTreeOption(provinceAndCity);
    }


    private List<DistrictTreeOption> convertTreeOption(List<DistrictDO> districtDOS) {
        List<DistrictTreeOption> result = districtDOS.stream()
                .filter(districtDO -> districtDO.getLevel().equals(DistrictLevelCode.province))
                .map(this::convert).collect(Collectors.toList());
        result.forEach(districtTreeOption -> {
            List<DistrictTreeOption> children = districtDOS.stream()
                    .filter(districtDO -> districtDO.getParentId().equals(districtTreeOption.getId()))
                    .map(this::convert).collect(Collectors.toList());
            children.forEach(item -> item.setLeaf(true));
            districtTreeOption.setTreeOptions(children);
        });
        return result;
    }

    private DistrictTreeOption convert(DistrictDO districtDO) {
        DistrictTreeOption province = new DistrictTreeOption();
        province.setLabel(districtDO.getName());
        province.setValue(districtDO.getCode());
        province.setId(districtDO.getId());
        return province;
    }

    @Override
    public Optional<List<DistrictDO>> queryProvinceAndCityByCodes(List<String> codes) {
        if (codes == null || codes.isEmpty()) {
            return Optional.empty();
        }
        List<DistrictDO> result = districtService.queryProvinceAndCity().orElseGet(ArrayList::new)
                .stream()
                .filter(districtDO -> codes.contains(districtDO.getCode()))
                .collect(Collectors.toList());
        return Optional.of(result);
    }
}
