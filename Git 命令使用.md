# Git 命令使用

## 1. 上传文件到新建的repository

1. `git add <文件名或目录>`

   如果想上传所有的可以使用 `git add .` 命令

2. `git commit -m "描述"`

3. `git remote add origin git@github.com:Select-60321/select-60321` 

   origin: 创建的指向远程代码库的标签，相当于存储后面跟着的网址

4. `git push -u origin master`

   master 就是要push到的分支

   此步很可能会出错，产生错误的原因很可能是：远程仓库的该分支有修改，但你并没有pull到本地，并且你也在本地有修改，这样就会出现系统不知道该以远程仓库为主还是本地仓库为主，所以冲突产生了。最直接的方法就是放弃本地修改，强制下拉：`git pull origin master --allow-unrelated-histories`



## 2. 更新本地代码到github

### 方法一

$ git fetch origin master 

从远程的origin仓库的master分支下载代码到本地的origin master



$ git log -p master.. origin/master

比较本地的仓库和远程参考的区别



$ git merge origin/master

把远程下载下来的代码合并到本地仓库，远程的和本地的合并



### 方法二

$ git fetch origin master:temp

从远程的origin仓库的master分支下载到本地并新建一个分支temp



$ git diff temp

比较master分支和temp分支的不同



$ git merge temp

合并temp分支到master分支



$ git branch -d temp

删除temp



## 3. 常用代码

`git remote ` 查看有哪些标签

`git remote -v` 查看标签指向的远程代码库

`git mv <filename> <foldername>/` 移动文件到某目录下

