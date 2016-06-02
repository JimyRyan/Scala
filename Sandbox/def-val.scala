def faltToField(df: DataFrame) {
    def func2(row: Row) : List[Row] = {
        List(row, row, row)
    }

    // 
    // OR 
    //
    
    val func = (row: Row) => {
        List(row, row, row)
    }
}
