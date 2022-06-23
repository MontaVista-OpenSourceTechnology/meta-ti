require linux-ti-staging_5.10.bb

# Look in the generic major.minor directory for files
# This will have priority over generic non-rt path
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-5.10:"

BRANCH = "ti-rt-linux-5.10.y"

SRCREV = "c0344a7bf119b7169765e13bef377735fa39cef9"
PV = "5.10.120+git${SRCPV}"
