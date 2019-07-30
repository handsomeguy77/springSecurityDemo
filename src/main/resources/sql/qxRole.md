pageQuery
===
* 翻页查询
select       @pageTag() {
                         *
                     @}
                        from QX_ROLE where 1=1
                                        @if(!isEmpty(Role)){
                                            and ROLE like #'%'+Role+'%'#
                                        @}
                                        @if(!isEmpty(Sm)){
                                            and SM like #'%'+Sm+'%'#
                                        @}
                
                
deleteById
===
*通过id进行删除操作
delete from QX_ROLE where ID=#Id#     

selectAll
===
*查询出所有的角色名
select * from QX_ROLE                 
