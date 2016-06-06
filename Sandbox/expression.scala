convert an Int to a String of a given length with leading zeros to align

The Java library has pretty good (as in excellent) number formatting support which is accessible from StringOps enriched String class:

scala> "%07d".format(123)
res5: String = 0000123

scala> "%07d".formatLocal(java.util.Locale.US, 123)
res6: String = 0000123

Edit post Scala 2.10: as suggested by fommil, from 2.10 on, there is also a formatting string interpolator:

val expr = 123
f"$expr%07d"
f"${expr}%07d"


