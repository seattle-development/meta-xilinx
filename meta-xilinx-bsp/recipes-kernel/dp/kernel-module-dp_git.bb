SUMMARY = "Xilinx DisplayPort Linux Kernel module"
DESCRIPTION = "Out-of-tree DisplayPort(DP) kernel modules provider for aarch64 devices"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=eb723b61539feef013de476e68b5c50a"

XLNX_DP_VERSION = "5.10.0"
PV = "${XLNX_DP_VERSION}"

S = "${WORKDIR}/git"

BRANCH ?= "master"
REPO   ?= "git://github.com/xilinx/dp-modules.git;protocol=https"
SRCREV ?= "249a69434cef40308deda8460274d4d73a7e29f2"

BRANCHARG = "${@['nobranch=1', 'branch=${BRANCH}'][d.getVar('BRANCH', True) != '']}"
SRC_URI = "${REPO};${BRANCHARG}"

inherit module

EXTRA_OEMAKE += "O=${STAGING_KERNEL_BUILDDIR}"
COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE_zynqmp = "zynqmp"
COMPATIBLE_MACHINE_versal = "versal"
