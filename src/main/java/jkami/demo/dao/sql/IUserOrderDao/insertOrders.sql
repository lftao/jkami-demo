<#list orders as os>
insert into tb_user_order(name,user_id,create_date) values('${os.name}',${os.user.id!os.userId},'${os.createDate?string("yyyy-MM-dd HH:mm:ss")}');
</#list>