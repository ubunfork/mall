# cvs文件导入到数据库

## 基本愈发觉得
``` 
load data [low_priority] [local] infile 'file_name txt' [replace | ignore]
into table tbl_name
[character set gbk]
[fields
[terminated by't']
[OPTIONALLY] enclosed by '']
[escaped by'\' ]]
[lines terminated by'n']
[ignore number lines]
[(col_name, )]
```
## 导入实例
```
 load data infile 'csv文件路径\\test.csv' 
 replace into table 表名              
 fields terminated by ',' 
 optionally enclosed by '"' 
 lines terminated by '\r\n' 
 ignore 1 lines(Id,@name,password);
```

 说明：
 >第一行就是导入文件；

 >第二行参看语法就会发现有两个词：replace 和 ignore 。replace和ignore关键词控制对现有的唯一键记录的重复的处理。如果你指定replace，新行将代替有相同的唯一键值的现有行。如果你指定ignore，跳过有唯一键的现有行的重复行的输入。如果你不指定任何一个选项，当找到重复键时，出现一个错误，并且文本文件的余下部分被忽略。

 >第三~四行很简单就是每个具体字段内容之间是以逗号隔开的，那就以逗号分开。 erminated by描述字段的分隔符，默认情况下是tab字符（\t） 。enclosed by描述的是字段的括起字符，就是说字段中如果有引号，就当做是字段的一部分。 语法中还有一个是 escaped by， 它描述的是转义字符。默认的是反斜杠（backslash：\ ）

 >第五行 lines terminated by是对每行进行分割，这里要注意一个问题，如果csv文件是在windows下生成，那分割用 ‘\r\n’，linux下用 ‘\n’。

 >第六行中 ignore 1 lines 是忽略第一行，因为第一行往往是字段名，后边括号中有个字段很特别 @name，它是说如果csv文件中有个字段我不想插进去，那就把对应字段名变成@name.

 ## 举例
```
SHOW VARIABLES LIKE "secure_file_priv";

load data infile '/opt/area_code_2019.csv'

into table cfg_cnarea character set utf8mb4 

fields terminated by ',' optionally enclosed by '"' escaped by '"'

lines terminated by '\n'
(area_code, name, level,parent_code);

```