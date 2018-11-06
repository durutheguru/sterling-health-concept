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

        partnerDataContainer : new Vue({
            el : "#partner-data-edit-container",

            data : {
                tabs : [
                    {
                        text : "Basic Details",
                        key : "BASIC_DETAILS"
                    },

                    {
                        text : "Images",
                        key : "IMAGES"
                    },

                    {
                        text : "Products",
                        key : "PRODUCTS"
                    },

                    {
                        text : "Advertisement",
                        key : "ADVERTISEMENT"
                    },

                    {
                        text : "Locations",
                        key : "LOCATIONS"
                    }
                ],

                selectedTab : {}
            },

            methods : {

                setSelectedTab : function(tab) {
                    this.selectedTab = tab;
                    _$$.vue.$emit(_$$.constants.EVENTS.PARTNER_EDIT_DETAILS_NEW_TAB, this.selectedTab);
                }

            },

            mounted : function() {
                var self = this;
                setTimeout(function() {
                    self.setSelectedTab(self.tabs[0])
                }, 300);
            }

        }),

        partnerEditContainer : new Vue({
            el : "#edit-partner-form",

            data : {
                partner : {},
                partnerInjected : false,
                showModal : false,
                modalData : {},
                selectedTab : {}
            },

            methods : {

                injectPartner : function() {
                    if (_$$.util.isValidString(inject.partner)) {
                        this.partner = JSON.parse(inject.partner);
                        this.partnerInjected = true;
                    }
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
                },

                setSelectedTab : function(tab) {
                    this.selectedTab = tab;
                    _$$.util.logInfo("Tab: " + JSON.stringify(this.selectedTab));
                },

                registerEditModeChangeListener : function() {
                    var self = this;
                    _$$.vue.$on(_$$.constants.EVENTS.PARTNER_EDIT_DETAILS_NEW_TAB, self.setSelectedTab);
                }

            },

            mounted : function() {
                this.injectPartner();
                this.registerEditModeChangeListener();
            }
        })
    });

})(rootObject);