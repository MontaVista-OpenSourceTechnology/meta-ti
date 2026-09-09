require u-boot-ti.inc

PR = "r0"

BRANCH = "ti-u-boot-2024.04"

SRCREV_uboot = "29d0c23d67ee7b88e46fe1753cd020e2b04c2ef6"

SRC_URI += "file://0001-scripts-dtc-pylibfdt-libfdt.i_shipped-Use-SWIG_Appen.patch"
SRC_URI += "file://0001-binman-migrate-form-pkg_resources-to-importlib.patch"
SRC_URI += "file://0001-Add-support-for-OpenSSL-Provider-API-2024-04.patch"
