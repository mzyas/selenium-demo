# Selenium自動化テストデモ

## 概要
SeleniumとJavaを使用したWebアプリケーションの自動化テストデモです。
Amazon.co.jpの検索機能をテスト対象として、E2E（エンドツーエンド）テストを実装しています。

## 使用技術
- Java 17
- Selenium 4.18.1
- JUnit 5.10.2
- Maven 3.6.1

## テスト内容
| テスト名 | 検証内容 |
|----------|---------|
| searchBoxIsDisplayed | トップページの検索ボックスが表示されているか |
| searchResultContainsKeyword | 検索後のページタイトルにキーワードが含まれるか |
| searchResultsAreDisplayed | 検索結果が1件以上表示されるか |

## 実行環境
- Windows 11
- Google Chrome
- IntelliJ IDEA

## 実行方法
1. リポジトリをクローン
   git clone https://github.com/mzyas/selenium-demo.git

2. IntelliJ IDEAでプロジェクトを開く

3. pom.xmlを右クリック → Maven → Reload project

4. AmazonSearchTest.javaを右クリック → Run