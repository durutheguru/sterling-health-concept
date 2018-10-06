(function(_$$) {

    Vue.config.debug = true;

    Vue.component('modal', {
        template: '#modal-template',

        props: {
            data: {
                type: Object,
                required: true
            }
        }
    });


    _$$.util.registerComponents({
        partnerEditContainer : new Vue({
            el : "#edit-partner-form",

            data : {
                partner : {},
                partnerInjected : false,
                showModal : false,
                modalData : {}
            },

            methods : {

                injectPartner : function() {
                    this.partner = JSON.parse(inject.partner);
                    this.partnerInjected = true;
                },

                editPartner : function() {
                    var self = this;

                    _$$.services.partnerService.updatePartner(
                        this.partner,

                        function() {
                            _$$.web.navigate("/partner/" + self.partner.id);
                        },

                        function(error) {
                            self.showModal = true;
                            self.modalData = {
                                header : "Error",
                                body : _$$.util.extractError(error)
                            };
                        }
                    );
                }

            },

            mounted : function() {
                this.injectPartner();
            }
        })
    });

})(rootObject);