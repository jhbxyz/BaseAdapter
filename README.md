# BaseAdapter
封装了RecyclerView和ListView的Adapter填充数据更方便
此项目中有源码和示例

## 知识点

### RecyclerView
* 1.SparseArray
    SparseArray(稀疏数组).他是Android内部特有的api,标准的jdk是没有这个类的.在Android内部用来替代HashMap<Integer,E>这种形式,
使用SparseArray更加节省内存空间的使用,SparseArray也是以key和value对数据进行保存的.使用的时候只需要指定value的类型即可.
并且key不需要封装成对象类型.
SparseArray存储数据占用的内存空间确实比HashMap要小一些

* 2.多条目数据类型
* 3.定义OnItemClickListener接口实现了条目点击和***条目中子view***的点击

### ListView
<mark>注意</mark>:多条目时必须复写getViewTypeCount方法



