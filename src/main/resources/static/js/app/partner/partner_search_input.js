(function(_$$) {

    _$$.util.registerComponents({
        partnerSearchInput: new Vue({
            el: "#partner-search-input",

            data: {
                key: ''
            },

            methods: {
                triggerSearch: function () {
                    if (!_$$.util.isValidString(this.key)) {
                        _$$.vue.$emit(_$$.constants.EVENTS.PARTNER_CLEAR_SEARCH);
                        return;
                    }

                    _$$.util.logInfo("Triggering Search for: " + this.key);
                    _$$.vue.$emit(_$$.constants.EVENTS.PARTNER_SEARCH, this.key);
                }
            }
        })
    })

})(rootObject);