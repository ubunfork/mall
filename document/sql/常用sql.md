## 修改表名
alter table old_name rename new_name;
## 添加表列
alter table test add  column add_name varchar(10); 
## 删除表列
alter table test drop  column del_name;
## 修改表列类型
alter table test modify address char(10)
alter table test change address address  char(40)

## 修改表列名
alter table test change  column address address1 varchar(30)
