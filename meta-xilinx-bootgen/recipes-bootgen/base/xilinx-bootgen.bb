SUMMARY = "Xilinx bootgen utility"
DESCRIPTION = "Generates boot images for Xilinx devices"
HOMEPAGE = "https://github.com/Xilinx/bootgen"

LICENSE="OpenSSL"

DEPENDS += "openssl"

BOOTGEN_DIR = "../git"
TAG = "2019.2"

LIC_FILES_CHKSUM = "file://${BOOTGEN_DIR}/LICENSE;md5=c979df673927004a489691fc457facff"

SRC_URI = "git://github.com/Xilinx/bootgen.git;protocol=https;tag=${TAG};name=bootgen"

inherit autotools

S = "${WORKDIR}/git"

#EXTRA_OEMAKE += "CROSS_COMPILER=arm-poky-linux-gnu-g++"
# CROSS_COMPILER=aarch64-linux-gnu-g++ LIBS=<opensslarm/lib/libssl.a> <opensslarm/lib/libcrypto.a> -ldl -lpthread INCLUDE_USER=-I<opensslarm/include>
do_compile () {
      # Build bootgen
     oe_runmake -C ${BOOTGEN_DIR}
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${BOOTGEN_DIR}/bootgen ${D}${bindir}
}

#BBCLASSEXTEND += "native nativesdk"
