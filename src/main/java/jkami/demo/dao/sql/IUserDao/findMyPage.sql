select
	*
from
	tb_user
where
	1=1
<#if map["name"]??>
    and name like '%${map["name"]}%'
</#if>
<#if map["id"]??>
    and id = '${map["id"]}'
</#if>
<#if id??>
    and id = '${id}'
</#if>