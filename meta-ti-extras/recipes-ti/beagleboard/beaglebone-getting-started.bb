SUMMARY = "BeagleBone Getting Started Guide"

PR = "r22"

inherit allarch

LICENSE = "CC-BY-SA-3.0 & GPL-3.0-or-later & MIT & PD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=f6f02761e31334c48f7021fb94c89aaa"

SRCREV = "05bedba192646152b7bc80b0accaea75aef864e5"
SRC_URI = "git://github.com/jadonk/beaglebone-getting-started.git;protocol=https;branch=master"

do_install() {
	install -d ${D}${datadir}/${PN}
	cp -R --no-dereference --preserve=mode,links ${S}/* ${D}${datadir}/${PN}
}

FILES:${PN} += "${datadir}/${PN}"
INSANE_SKIP:${PN} = "file-rdeps"
