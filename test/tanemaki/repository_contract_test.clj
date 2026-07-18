(ns tanemaki.repository-contract-test (:require [clojure.edn :as edn] [clojure.java.io :as io] [clojure.test :refer [deftest is]]))
(deftest boundary (let [c (edn/read-string (slurp "repository-contracts.edn"))]
 (is (= :edn (get-in c [:canonical :format])))
 (doseq [p ["manifest.edn" "schema.edn" "lex/ddScorecard.edn" "lex/grantProposal.edn" "wire/manifest.jsonld" "wire/lexicons/ddScorecard.json" "wire/lexicons/grantProposal.json"]] (is (.isFile (io/file p)) p))
 (doseq [p (:forbidden-root-paths c)] (is (not (.exists (io/file p))) p))))
