SRC_URI += " \
    file://mb-no-tree-loop-distribute-patterns.patch \
    file://microblaze_generic.cfg \
    "

# MicroBlaze is a uImage target, but its not called 'uImage' instead it is called 'linux.bin.ub'
python () {
    if d.getVar('KERNEL_IMAGETYPE', True).endswith('.ub'):
        d.setVar('DEPENDS', "%s u-boot-mkimage-native" % d.getVar('DEPENDS', True))
}
