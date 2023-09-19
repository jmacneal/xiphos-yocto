# Build Dependencies:
Aside from the usual yocto/bitbake build dependencies, you'll need libssl-dev.

On Ubuntu/Debian, this can be installed with `apt install libssl-dev`.

# Build
First, make sure to do a submodule update to bring in the meta-raspberrypi layer:

``` bash
git submodule update --init --recursive
```

Next, you can build the raspberry pi image with:

``` bash
source oe-init-build-env
bitbake core-image-minimal
```

The resulting image will be located at

``` bash
tmp/deploy/images/raspberrypi3/core-image-minimal-raspberrypi3.wic.bz2
```

It can be written to an sd card or USB drive using `dd` or your favorite tool.

The default username is root, and the password is blank.

