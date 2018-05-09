require linux-ti-staging_4.14.bb

# Look in the generic major.minor directory for files
# This will have priority over generic non-rt path
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.14:"

BRANCH = "ti-rt-linux-4.14.y"

SRCREV = "abfcd79f10da4eb13f9e8d3bc8eae007a8111fe9"
PV = "4.14.39+git${SRCPV}"
