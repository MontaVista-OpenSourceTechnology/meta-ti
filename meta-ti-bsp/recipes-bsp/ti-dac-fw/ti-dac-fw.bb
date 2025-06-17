DESCRIPTION = "TI DAC TAD5212 config prebuild binary firmware"

require recipes-bsp/ti-linux-fw/ti-linux-fw.inc

LICENSE = "TI-TFL"
LIC_FILES_CHKSUM = "file://${THISDIR}/../../licenses/TI-TFL;md5=a1b59cb7ba626b9dbbcbf00f3fbc438a"

PV = "${TAD5212_FW_VERSION}"
PR = "${INC_PR}.0"

COMPATIBLE_MACHINE = "am62dxx"

TAD5212_1DEV = "TAD5212_01.bin"
TAD5212_4DEV = "TAD5212_04.bin"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 ${S}/ti/tad5212/${TAD5212_1DEV} ${D}${nonarch_base_libdir}/firmware/
	install -m 0644 ${S}/ti/tad5212/${TAD5212_4DEV} ${D}${nonarch_base_libdir}/firmware/
}
