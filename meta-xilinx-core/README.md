meta-xilinx-core
================

This layer provides support for MicroBlaze, Zynq and ZynqMP.


Maintainers, Mailing list, Patches
==================================

Please send any patches, pull requests, comments or questions for this layer to
the [meta-xilinx mailing list](https://lists.yoctoproject.org/listinfo/meta-xilinx):

	meta-xilinx@lists.yoctoproject.org

Maintainers:

	Sai Hari Chandana Kalluri <chandana.kalluri@xilinx.com>
	Mark Hatle <mark.hatle@xilinx.com>

Dependencies
============

This layer depends on:

	URI: git://git.openembedded.org/bitbake

	URI: git://git.openembedded.org/openembedded-core
	layers: meta

Configuring Machines
====================

All machines that use meta-xilinx-tools should be derived from one of the
following: microblaze-generic, zynq-generic, zynqmp-generic, or 
versal-generic.

microblaze-generic requries the include of the meta-microblaze layer

zynq-generic, zynqmp-generic and versal-generic each require a device-tree
to be defined.  The device tree can be manually passed in via the
variable CONFIG_DTFILE.  Note, some items in the system may expect the
device-tree to be referenced to system-top.dtb.
Enabling meta-xilinx-tools will generate the appropriate device tree in most
cases.

Zynqmp-generic requires pmu-firmware.  The firmware can be passed directly
as a path to a binary: PMU_FILE, you may use the generic built version
by including meta-xilinx-standalone, the XSCT version by adding
meta-xilinx-tools or the DTB workflow version using
meta-xilinx-standalone-experimental.

Versal-generic requires both PLM and PSM firmware to be specified.  They can
be specified as a path to a binary using PLM_FILE and PSM_FILE.  Or they can
be generated by including meta-xilinx-standalone, the XSCT version by adding
meta-xilinx-tools or the DTB workflow version using
meta-xilinx-standalone-experimental.  Additionally some configurations may
require you to specify the path to a PDI file using PDI_PATH.  The XSCT
version will extract the PDI automatically.


Recipe Licenses
===============

Due to licensing restrictions some recipes in this layer rely on closed source
or restricted content provided by Xilinx. In order to use these recipes you must
accept or agree to the licensing terms (e.g. EULA, Export Compliance, NDA,
Redistribution, etc). This layer **does not enforce** any legal requirement, it
is the **responsibility of the user** the ensure that they are in compliance
with any licenses or legal requirements for content used.

In order to use recipes that rely on restricted content the `xilinx` license
flag must be white-listed in the build configuration (e.g. `local.conf`). This
can be done on a per package basis:

	LICENSE_FLAGS_WHITELIST += "xilinx_pmu-rom-native"

or generally:

	LICENSE_FLAGS_WHITELIST += "xilinx"

Generally speaking Xilinx content that is provided as a restricted download
cannot be obtained without a Xilinx account, in order to use this content you
must first download it with your Xilinx account and place the downloaded content
in the `downloads/` directory of your build or on a `PREMIRROR`. Attempting to
fetch the content using bitbake will fail, indicating the URL from which to
acquire the content.
