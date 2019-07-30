pageQuery
===
* 翻页查询
select       @pageTag() {
                         *
                     @}
                        from QX_USER where 1=1
                                        @if(!isEmpty(Username)){
                                            and USERNAME like #'%'+Username+'%'#
                                        @}
                                        @if(!isEmpty(Qq)){
                                            and QQ like #'%'+Qq+'%'#
                                        @}
                                        
insertUser
===
*添加功能（密码为MD5的格式）
insert into QX_USER (USERNAME,PASSWORD,QQ) value(#Username#,md5(#Password#),#Qq#)
 
                                        
deleteById
===
*通过id进行删除操作
delete from QX_USER where ID=#Id#

selectAll
===
*查询出所有的用户名
select * from QX_USER     

selectByUsername
===
*通过Username进行查询
select * from QX_USER where USERNAME=#username#

updateByUsername
===
*通过用户名更新角色（role）
update QX_USER set ROLE=#Role# where USERNAME=#Username#