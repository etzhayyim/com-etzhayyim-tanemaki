(require '[clojure.test :as t])
(def suites '[tanemaki.methods.test-cid tanemaki.methods.test-datom-emit
 tanemaki.methods.test-score-contributions tanemaki.tests.test-analyze
 tanemaki.tests.test-coverage tanemaki.tests.test-kotoba tanemaki.tests.test-propose
 tanemaki.tests.test-wasm tanemaki.murakumo-test tanemaki.repository-contract-test])
(apply require suites)
(let [{:keys [fail error] :as r} (apply t/run-tests suites)]
 (println (select-keys r [:test :pass :fail :error])) (when (pos? (+ fail error)) (System/exit 1)))
