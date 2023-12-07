package com.lin.xxux.common.utils.tree;

import cn.hutool.core.lang.tree.TreeUtil;
import com.lin.xxux.model.acl.Permission;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/7 07:54
 */
public class PermissionUtil {

    /**
     * 使用递归方法建菜单
     */
    public static List<Permission> build(List<Permission> treeNodes) {
        List<Permission> trees = new ArrayList<>(); //初始化树形结构集合
        for (Permission treeNode : treeNodes) { //遍历所有节点
            if (treeNode.getPid().equals(0L)) { //如果是父节点
                treeNode.setLevel(1); //设置层级为1
                trees.add(findChildren(treeNode, treeNodes)); //递归查找子节点
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     */
    private static Permission findChildren(Permission treeNode, List<Permission> treeNodes) {
        treeNode.setChildren(new ArrayList<Permission>()); //清空子节点

        for (Permission it : treeNodes) { //遍历所有节点，将父菜单id与传过来的id比较
            if(treeNode.getId().equals(it.getPid())) { //如果是父子关系，添加到父节点下
                it.setLevel(treeNode.getLevel() + 1); //设置层级
                if (treeNode.getChildren() == null) { //判断有没有子节点
                    treeNode.setChildren(new ArrayList<Permission>()); //初始化子节点
                }
                treeNode.getChildren().add(findChildren(it, treeNodes));  //递归添加子节点
            }
        }
        return treeNode; //返回父节点
    }


}
