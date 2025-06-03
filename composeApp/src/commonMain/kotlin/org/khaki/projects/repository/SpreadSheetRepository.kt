package org.khaki.projects.repository

/**
 * SpreadSheetRepositoryのインターフェース
 */
interface SpreadSheetRepository {
    /**
     * 指定されたスプレッドシートIDと範囲のデータを読み取る
     * 成功したらデータのリスト (行のリスト、各行はセルのリスト)、失敗したらnullとかエラーを返す感じ
     */
    suspend fun getSheetData(spreadsheetId: String, range: String): List<List<String>>?

    /**
     * 指定されたスプレッドシートIDと範囲にデータを書き込む
     * 成功したらtrue、失敗したらfalseとか
     */
    suspend fun updateSheetData(spreadsheetId: String, range: String, values: List<List<Any>>): Boolean
}
