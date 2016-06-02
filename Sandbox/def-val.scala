def faltToField(df: DataFrame) {
    val func = (row: Row) => List[Row] = {
        List(row, row, row)
    }

    // 
    // OR 
    //
    
    def func2(row: Row) : List[Row] = {
        List(row, row, row)
    }
}
