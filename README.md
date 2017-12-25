# TetrisGame
這是期末專案，大家記得做以下事情，只需要做一次
 * 先設定你的基本資料(之後commit的時候才容易知道作者是誰)
 ```
 git config --global user.name "yuu"
 git config --global user.email "a29104705@gmail.com"
 ```

 * 把專案clone下來
 ```
 git clone https://github.com/Yuukuni/TetrisGame.git
 ```
 * 建立自己的分支
 ```
 git branch ***
 ```

然後有做變更再更新

### 每次撰寫code要做的事
## 流程

 * 確認master的檔案為最新。原則上應該不會有人動你的分支所以自己的不用更新，其他人分支就看你要不要更新了
 ```
 git checkout master
 git pull
 ```
 * 切回自己的分支
 ```
 git checkout *** //***為自己的分支名稱
 ```
 * 將master與自己分支merge
 ```
 git merge master
 ```
 * 開始打code
 * 有變更或新增的檔案打完後記得add、commit、push
 ```
 git push origin *** // ***為自己分支名稱
 ```
 * 確認可以用之後pull regust至master，這點是在github上使用
 ```
 git checkout master //先切換至master
 git merge *** //***為自己的分支名稱
 git push
 ```

### 簡易指令教學

 * 新增檔案
 ```
 git add 檔案名稱
 ex:git add readme.md
 ```
 * 提交變更/建立新版本
 ```
 git commit -m "註解"
 ex:git commit -m "updata readme"
 ```
 * 同步到雲端
 ```
 git push
 ```
 * 查看版本紀錄
 ```
 git log
 ```
 * 查看你資料夾內的索引狀態，例如是不是最新版 有沒有要commit的
 ```
 git status
 ```
 * 刪除檔案
 ```
 git rm '檔案名稱'
 ```
 * 更名
 ```
 git mv t1.txt t2.txt
 ```
 * 新增分支
 ```
 git branch 名字
 ```
 * 切換至分支
 ```
 git checkout yuukuni
 or
 git checkout master
 ```
 * 合併分支至master
  ```
 git checkout master //先切換至master
 git merge *** //***為自己的分支名稱
 git push
 ```

### 參考網站
 * [Git筆記(入門)](http://tech-marsw.logdown.com/blog/2013/08/16/git-notes-github)
 * [Git筆記(分工設定篇)](http://tech-marsw.logdown.com/blog/2013/08/17/git-notes-github-n-person-cooperation-settings)
 * [Git筆記(分工流程篇)](http://tech-marsw.logdown.com/blog/2013/08/18/git-notes-cooperation-flow)
 * [GitFlow](https://medium.com/kuma%E8%80%81%E5%B8%AB%E7%9A%84%E8%BB%9F%E9%AB%94%E5%B7%A5%E7%A8%8B%E6%95%99%E5%AE%A4/%E5%9F%BA%E7%A4%8E-git-flow-%E5%B7%A5%E4%BD%9C%E6%B3%95-fa50b1dddc4f) 好的Git分支使用方式

### 參考影片
 * [GitFlow教學影片](https://www.youtube.com/watch?v=zXlta66thZY) 中文版教學

### 軟體介紹
 * [SourceTree](https://www.inote.tw/sourcetree) 覺得不喜歡看cmd想要圖形化介面可以用這個程式

### 簡報下載
 * [認識 Git 版本控制與 GitHub 協作平台](https://drive.google.com/file/d/1caR1ty-_kZa_WMDj_zSuuHKRredeBKeu/view?usp=sharing)
 * [作業一](https://drive.google.com/file/d/1K0BYNfRRoR_pIvOe3WNeIc40L8rtl6R8/view?usp=sharing) 從23頁開始
