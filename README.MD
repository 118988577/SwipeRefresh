滑动刷新实现

滑动刷新界面模式是由 SwipeRefreshLayout 微件中实现，将该微件作为 ListView 或 GridView 的父项添加到布局文件，并实现在用户执行滑动手势时调用的刷新行为

主要用到SwipeRefreshLayout.OnRefreshListener 接口及其 onRefresh() 方法。

当用户做出滑动手势时，系统会调用 onRefresh() 方法。
应将实际更新操作的代码放在单独的方法中，并通过 onRefresh() 实现调用该更新方法。这样，当用户从操作栏触发刷新时，您可以使用相同的更新方法执行更新。
更新方法会在完成数据更新后调用 setRefreshing(false)。调用此方法可指示 SwipeRefreshLayout 移除进度指示器并更新视图内容。
在整合到项目中时，需要添加以下支持库：
androidx.swiperefreshlayout
（官方示例中使用的是android.support.v4.widget.SwipeRefreshLayout，现在谷歌把支持库都移入到androidx中了，所以本示例项目使用的androidx）
更详细的使用说明可参见官方教程：https://developer.android.google.cn/training/swipe。
