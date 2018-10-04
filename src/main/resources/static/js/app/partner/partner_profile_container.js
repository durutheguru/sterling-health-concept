(function(_$$) {

    _$$.util.registerComponents({
        partnerProfileContainer : new Vue({
            el : "#partner-profile-container",

            methods : {

                managedString : _$$.util.managedString,

                getPartnerLogoImage : _$$.services.partnerService.getPartnerLogoImage

            }
        })
    });

})(rootObject);