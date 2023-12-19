package com.lin.xxux.service.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.model.product.Comment;
import com.lin.xxux.service.product.mapper.CommentMapper;
import com.lin.xxux.service.product.service.CommentService;
import org.springframework.stereotype.Service;

/**
* @author linsz
* @description 针对表【comment(商品评价)】的数据库操作Service实现
* @createDate 2023-12-11 10:37:41
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService {

}




