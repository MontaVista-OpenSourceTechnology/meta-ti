SECTION = "kernel"
SUMMARY = "Linux kernel for TI devices"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

require recipes-kernel/linux/ti-kernel.inc

inherit ${KERNEL_BASE_CLASS}

require recipes-kernel/linux/setup-defconfig.inc
include ${@ 'recipes-kernel/linux/ti-extras.inc' if d.getVar('TI_EXTRAS') else ''}

DEPENDS += "gmp-native libmpc-native"

# Look in the generic major.minor directory for files
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-6.6:"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}"

BRANCH ?= "ti-linux-6.6.y"

SRCREV ?= "a7758da17c2807e5285d6546b6797aae1d34a7d6"
PV = "6.6.58+git"

KERNEL_REPRODUCIBILITY_PATCHES = " \
    file://0001-vt-conmakehash-improve-reproducibility.patch \
"

SRC_URI += "\
    file://0001-move-common-SSL-helper-functions-to-a-header.patch \
    file://0002-avoid-using-deprecated-ERR_get_error_line.patch \
    file://0003-use-pkcs11-provider-for-OPENSSL-MAJOR-3.patch \
"

# Special configuration for remoteproc/rpmsg IPC modules
module_conf_rpmsg_client_sample = "blacklist rpmsg_client_sample"
module_conf_ti_k3_r5_remoteproc = "softdep ti_k3_r5_remoteproc pre: virtio_rpmsg_bus"
module_conf_ti_k3_dsp_remoteproc = "softdep ti_k3_dsp_remoteproc pre: virtio_rpmsg_bus"
KERNEL_MODULE_PROBECONF += "rpmsg_client_sample ti_k3_r5_remoteproc ti_k3_dsp_remoteproc"
