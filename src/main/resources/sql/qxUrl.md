pageQuery
===
* 翻页查询
select       @pageTag() {
                         *
                     @}
                        from QX_URL where 1=1
                                        @if(!isEmpty(Name)){
                                            and NAME like #'%'+Name+'%'#
                                        @}
                                        @if(!isEmpty(Sm)){
                                            and SM like #'%'+Sm+'%'#
                                        @}
                                      
selectByUrlName
===
*通过url名字来进行查询，看看该url是否已经拥有对应的角色
select * from QX_URL where NAME=#Name#

updateByUrlName
===
*通过url名字来更新对应的角色(roles)
update QX_URL set ROLES=#Roles# where NAME=#Name#

deleteById
===
*通过id进行删除操作
delete from QX_URL where ID=#Id#

selectAll
===
*查询出所有的url
select * from QX_URL 