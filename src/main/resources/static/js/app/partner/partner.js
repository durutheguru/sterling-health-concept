(function(_$$) {

     new Vue({
        el : "#partner-list-container",

        data : {
            partners : [],
            partnersLoading : false
        },

        methods : {

            loadPartners : function() {
                var self = this;
                self.partnersLoading = true;

                axios
                    .get(_$$.env.url + "/api/v1/partner")
                    .then(function(response) {
                        self.partnersLoading = false;
                        self.partners = response.data;
                    })
                    .catch(function(error) {
                        self.partnersLoading = false;
                        _$$.util.logInfo(error.message);
                    });
            },

            managedString : _$$.util.managedString

        },

        mounted : function() {
            this.loadPartners();
        }
    });

})(rootObject);