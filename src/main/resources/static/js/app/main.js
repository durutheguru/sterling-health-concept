
var rootObject = {
    vue : new Vue(),
    services:{},
    components : {},
    constants : {}
};


//TODO: load this from injected profile
var selectedConfigName = "DEV";


(function(_$$) {

    function EnvConfig(init) {
        for (var i in init) {
            if (init.hasOwnProperty(i)) {
                this[i] = init[i];
            }
        }
    }

    var configs = [
        new EnvConfig({
            name : "DEV",
            debug : true,
            url : "http://96.126.116.70"
        }),

        new EnvConfig({
            name : "PROD"
        })
    ];


    var selectedConfig = null;

    for (var i = 0; i < configs.length; i++) {
        if (configs[i].name == selectedConfigName) {
            selectedConfig = configs[i];
        }
    }


    rootObject.env = selectedConfig;


})(rootObject);
