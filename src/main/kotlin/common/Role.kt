package common

@Suppress("MagicNumber")
sealed class Role(val id: Int) {
    data object NoAccess : Role(0)
    data object MinimalAccess : Role(5)
    data object Guest : Role(10)
    data object Reporter : Role(20)
    data object Developer : Role(30)
    data object Maintainer : Role(40)
    data object Owner : Role(50)
}
