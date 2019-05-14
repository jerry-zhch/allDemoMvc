package org.sy.library.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.sy.library.entity.HosInf;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sy
 * @since 2019-05-13
 */
@Mapper
@Component
public interface HosInfMapper extends BaseMapper<HosInf> {

}
