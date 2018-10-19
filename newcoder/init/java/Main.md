## 知识点一：

```java
int[] arr = {1,2,3};
Integer[] Arr = {1,2,3};

List arrs = Arrays.asList(arr); // 一个元素
List Arrs = Arrays.asList(Arr); // 三个元素

int arr2 = (int[])arrs.get(0); // arr2 == arr [1,2,3];
// Arrs则是真正的List{1,2,3};
```

```java
// Integer数组转换成List
LinkedList<Integer> list =new LinkedList<Integer>(Arrays.asList(Arrs));
```

