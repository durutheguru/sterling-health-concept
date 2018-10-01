(function (_$$) {

    _$$.util.registerComponents({
        partnerListViewModel: new Vue({
            el: "#partner-list-container",

            data: {
                partners: [],
                partnersLoading: false,
                searching: false,
                searchResult: {
                    searchResultGroups : []
                },
                viewMode: _$$.constants.VIEW_MODE.PARTNER_LIST
            },

            methods: {

                loadPartners: function () {
                    var self = this;
                    self.partnersLoading = true;
                    self.viewMode = _$$.constants.VIEW_MODE.PARTNER_LIST;

                    _$$.services.partnerService.loadPartners(
                        function (response) {
                            self.partnersLoading = false;
                            self.partners = response.data;
                            _$$.components.partnerUploadViewModel.setPartnerCount(self.partners.length);
                        },

                        function (error) {
                            self.partnersLoading = false;
                            _$$.util.logError(error.message);
                        }
                    );
                },

                searchPartners: function (key) {
                    var self = this;
                    self.searching = true;
                    self.viewMode = _$$.constants.VIEW_MODE.PARTNER_SEARCH_RESULTS;

                    _$$.services.partnerService.searchPartners(
                        key,

                        function (response) {
                            self.searching = false;
                            self.searchResult = response.data;
                            _$$.util.logInfo("Search Results: " + JSON.stringify(response));
                        },

                        function (error) {
                            self.searching = false;
                            _$$.util.logError(error.message);
                        }
                    );
                },

                initializeSearchListener: function () {
                    var self = this;
                    _$$.vue.$on(_$$.constants.EVENTS.PARTNER_SEARCH, self.searchPartners);

                    _$$.vue.$on(_$$.constants.EVENTS.PARTNER_CLEAR_SEARCH, self.loadPartners);
                },

                busy : function() {
                    return this.partnersLoading || this.searching;
                },

                isViewModeSearch : function() {
                    return this.viewMode == _$$.constants.VIEW_MODE.PARTNER_SEARCH_RESULTS;
                },

                isViewModeList : function() {
                    return this.viewMode == _$$.constants.VIEW_MODE.PARTNER_LIST;
                },

                partnerListReady: function() {
                    return !this.partnersLoading && this.partners.length;
                },

                searchResultsReady : function() {
                    return this.searchResult != null && this.searchResult.searchResultGroups.length;
                },

                quantity : _$$.util.quantity

            },

            mounted: function () {
                this.loadPartners();
                this.initializeSearchListener();
            }
        })
    });


})(rootObject);