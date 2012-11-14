(ns functional_stereotype_test
  (:use clojure.test
        functional_stereotype))

(deftest value-for-name-should-return-valid-stereotype-when-passed-description
  (is (= :newzealand (find-stereotype "a person from new zealand"))))

(deftest value-for-name-should-return-valid-stereotype-when-passed-enum-value-itself
  (is (= :manchester (find-stereotype "manchester"))))

(deftest value-for-name-should-return-valid-stereotype-when-passed-alternative-name
  (is (= :liverpool (find-stereotype "thief"))))

(deftest value-for-name-should-be-case-insensitive
  (is (= :preston (find-stereotype "scally")))
  (is (= :preston (find-stereotype "SCALLY")))
  (is (= :preston (find-stereotype "ScAlLy"))))

(deftest value-for-name-should-throw-error-when-passed-invalid-string
  (is (thrown-with-msg?
        IllegalArgumentException
        #"Invalid Stereotype \[Awesome\]\. Must be one of \[a person from australia, a person from liverpool, a person from manchester, a person from new zealand, a person from preston, aussie, australia, fighter, kiwi, legend, liverpool, manc, manchester, mancunian, newzealand, preston, scally, scouser, thief\]"
        (find-stereotype "Awesome"))))