(ns lens.runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [lens.core-test]))

(doo-tests 'lens.core-test)
