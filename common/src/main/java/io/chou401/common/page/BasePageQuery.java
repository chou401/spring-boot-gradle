package io.chou401.common.page;

import io.chou401.common.constant.CommonConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页查询参数
 * <p>
 * {@code @author}  chou401
 * {@code @date} 2018-11-08
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "分页查询参数")
public abstract class BasePageQuery extends BaseOrderQuery {
    private static final long serialVersionUID = -6831815750258997473L;

    @Schema(description = "页码,默认为1", example = "1")
    private Integer pageIndex = CommonConstant.DEFAULT_PAGE_INDEX;

    @Schema(description = "页大小,默认为10", example = "10")
    private Integer pageSize = CommonConstant.DEFAULT_PAGE_SIZE;

    @Schema(description = "关键字搜索")
    private String keyword;

    public Integer getPageIndex() {
        if (pageIndex == null || pageIndex <= 0) {
            pageIndex = CommonConstant.DEFAULT_PAGE_INDEX;
        }
        return pageIndex;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize <= 0) {
            pageSize = CommonConstant.DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

}
