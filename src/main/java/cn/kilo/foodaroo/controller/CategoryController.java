package cn.kilo.foodaroo.controller;

import cn.kilo.foodaroo.common.Result;
import cn.kilo.foodaroo.common.ThreadLocalUserId;
import cn.kilo.foodaroo.pojo.Category;
import cn.kilo.foodaroo.pojo.Employee;
import cn.kilo.foodaroo.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * CategoryController is a REST controller for handling category-related HTTP requests.
 *
 * @version 0.0.1-SNAPSHOT
 * @author kilo
 */
@RestController
@RequestMapping("/category")
public class CategoryController  {

    @Autowired
    private CategoryService categoryService;


    /**
     * Saves a category to the database.
     * @param request The HTTP request.
     * @param category The category to save.
     * @return A Result object containing a success message.
     */
    @PostMapping
    public Result<String> saveCategory(HttpServletRequest request,
                                       @RequestBody Category category){
        Long creatorEmployeeId = (Long) request.getSession().getAttribute("employeeId");
        ThreadLocalUserId.setUserId(creatorEmployeeId);

        category.setName(category.getName().trim());

        categoryService.save(category);
        return Result.success("Add employee successfully");
    }

    /**
     * Gets a page of categories from the database.
     * @param page The page number to retrieve.
     * @param pageSize The number of categories to include in the page.
     * @return A Result object containing a page of Category objects.
     */
    @GetMapping("/page")
    public Result<Page<Category>> getPage(int page, int pageSize){
        Page pageInfo = new Page(page, pageSize);
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.orderByAsc(Category::getSort);
        Page pageResult = categoryService.page(pageInfo, queryWrapper);

        return Result.success(pageResult);
    }

    /**
     * not used yet
     *
     * @return
     */
    @GetMapping("/{id}")
    public Result<Category> getCategory(){
        return null;
    }


    /**
     * Naive implementation of delete Category info function
     *
     * @param id
     * @return
     */
    @DeleteMapping()
    public Result<String> deleteCategory(Long id){
        categoryService.removeCategoryById(id);
        return Result.success("Delete successfully");
    }


    /**
     * Update Employee info
     * @param request
     * @param category
     * @return
     */
    @PutMapping
    public Result<String> updateCategory(HttpServletRequest request, @RequestBody Category category){
        Long updaterId = (Long) request.getSession().getAttribute("employeeId");
        ThreadLocalUserId.setUserId(updaterId);

        boolean updateResult = categoryService.updateById(category);
        if(updateResult){
            return Result.success("Update Category info successfully");
        }else {
            return Result.error("Update Category info error");
        }
    }


    /**
     * Get Category list according to the condition
     * @param category
     * @return
     */
    @GetMapping("/list")
    public Result<List<Category>> getCategoryList(Category category){
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(category.getType() != null, Category::getType, category.getType());
        lambdaQueryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);

        List<Category> list = categoryService.list(lambdaQueryWrapper);
        return Result.success(list);
    }

}
