# DB2.0
手机录频连接：
https://github.com/cuihengyuan/DB2.0/blob/master/%E5%BD%95%E5%B1%8F_20190228_164020.mp4
##**总结**
###**心得**
我知道我做得和他们比起来差了很多，但也有认真看书，花了很多很多的时间，踩了很多的坑，我在群里没说过什么话，也基本没有问过学长学姐们问题，所以可能学长学姐们根本不知道我这个人虽然我每次作业都交了上课也都来了的.........
以前觉得自己用的APP没有很厉害，但学了之后才发现这根本不是这么简单的事情，自己的写的App才是真的菜。
我不觉得写程序是一件无聊枯燥的事情，比起做出一道道高数题得高分，我的程序可以跑起来或者实现了新的功能更加吸引我。
上学期没有学好，课上很多东西都没有明白，这学期事务更多，学的东西会更多，我有足够的动力去学习，但我怕我的时间不够，真的我上大学以来最真切的感受就是
时间不够，我恨不得一下子学完所有的东西但这不可能。尽管如此我还是很希望坚持道最后，成为学长学姐那样的人。
####**用到的知识**
**1**
*在recyclerView的adapter里面写接口并暴露给activity等来实现recycleView的点击,**可以实现相同的适配器在不同Context下的不同的点击事件***
 在adapter中
 ` private OnItemClickListener mOnItemClickListener;
public interface OnItemClickListener {
        void onClick(int position);
        void onLongClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    } 
     ` 
     在activity或fragment中
`      recyclerViewAdapter.setOnItemClickListener(new RecyclerView_adapter.OnItemClickListener() {
                            @Override
                            public void onClick(int position) {
                                //点击事件
                            }
                            @Override
                            public void onLongClick(int position) {
                                  //长点击事件
                            }
                        });`
 **2**
 使用GridView来填充搜索界面
 ![搜索界面](https://raw.githubusercontent.com/cuihengyuan/DB2.0/master/超级截屏_20190301_164330.png)
 
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
