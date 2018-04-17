// @GENERATOR:play-routes-compiler
// @SOURCE:D:/Study/BigData/Assignment/Project/csye7200-spring2018-group9/conf/routes
// @DATE:Thu Mar 22 12:12:25 EDT 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
