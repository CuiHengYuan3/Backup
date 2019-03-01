# DB2.0
手机录频连接：
https://github.com/cuihengyuan/DB2.0/blob/master/%E5%BD%95%E5%B1%8F_20190228_164020.mp4
##**总结**
###**用到的知识**
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
 ![pic]( )
 
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
