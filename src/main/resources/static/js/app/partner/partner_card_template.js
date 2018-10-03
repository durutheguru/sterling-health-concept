(function (_$$) {


    Vue.component('partner-card', {
        template: "#partner-card-template",
        props: {
            partner: {
                type: Object,
                required: true
            }
        },

        methods: {

            managedString: _$$.util.managedString,

            getPartnerLogoImage : _$$.services.partnerService.getPartnerLogoImage

        }
    });


})(rootObject);