(ns hubble.views
  (:require [reagent.core :as r]
            [clojure.string :as str]
            [web.Element :as el]
            [reagent.cookies :as rc]
            ["react-d3-graph" :refer [Graph]]))

(def graph (r/adapt-react-class Graph))

(defn link-pairs
  [points]
  (partition 2 1 points))

(defn links
  [link-pairs]
  (map
    (fn [[source target]]
      {:source source
       :target target})
    link-pairs))

(def view-box "0 0 700 600")

(defn document
  [color]
  [:svg.svg-inline--fa.fa-file-invoice.fa-w-16
   {:aria-hidden "true"
    :focusable   "false"
    :data-prefix "fas"
    :data-icon   "file-invoice"
    :role        "img"
    :xmlns       "http://www.w3.org/2000/svg"
    :viewBox     view-box}
   [:path {:fill color :d "M288 256H96v64h192v-64zm89-151L279.1 7c-4.5-4.5-10.6-7-17-7H256v128h128v-6.1c0-6.3-2.5-12.4-7-16.9zm-153 31V0H24C10.7 0 0 10.7 0 24v464c0 13.3 10.7 24 24 24h336c13.3 0 24-10.7 24-24V160H248c-13.2 0-24-10.8-24-24zM64 72c0-4.42 3.58-8 8-8h80c4.42 0 8 3.58 8 8v16c0 4.42-3.58 8-8 8H72c-4.42 0-8-3.58-8-8V72zm0 64c0-4.42 3.58-8 8-8h80c4.42 0 8 3.58 8 8v16c0 4.42-3.58 8-8 8H72c-4.42 0-8-3.58-8-8v-16zm256 304c0 4.42-3.58 8-8 8h-80c-4.42 0-8-3.58-8-8v-16c0-4.42 3.58-8 8-8h80c4.42 0 8 3.58 8 8v16zm0-200v96c0 8.84-7.16 16-16 16H80c-8.84 0-16-7.16-16-16v-96c0-8.84 7.16-16 16-16h224c8.84 0 16 7.16 16 16z"}]])

(defn video
  [color]
  [:svg.svg-inline--fa.fa-play-circle.fa-w-16
   {:aria-hidden "true" :focusable "false" :data-prefix "fas" :data-icon "play-circle" :role "img" :xmlns "http://www.w3.org/2000/svg" :viewBox view-box}
   [:path {:fill color :d "M336.2 64H47.8C21.4 64 0 85.4 0 111.8v288.4C0 426.6 21.4 448 47.8 448h288.4c26.4 0 47.8-21.4 47.8-47.8V111.8c0-26.4-21.4-47.8-47.8-47.8zm189.4 37.7L416 177.3v157.4l109.6 75.5c21.2 14.6 50.4-.3 50.4-25.8V127.5c0-25.4-29.1-40.4-50.4-25.8z"}]])

(defn product
  [color]
  [:svg.svg-inline--fa.fa-toolbox.fa-w-16
   {:aria-hidden "true" :focusable "false" :data-prefix "fas" :data-icon "toolbox" :role "img" :xmlns "http://www.w3.org/2000/svg" :viewBox view-box}
   [:path {:fill color :d "M502.63 214.63l-45.25-45.25c-6-6-14.14-9.37-22.63-9.37H384V80c0-26.51-21.49-48-48-48H176c-26.51 0-48 21.49-48 48v80H77.25c-8.49 0-16.62 3.37-22.63 9.37L9.37 214.63c-6 6-9.37 14.14-9.37 22.63V320h128v-16c0-8.84 7.16-16 16-16h32c8.84 0 16 7.16 16 16v16h128v-16c0-8.84 7.16-16 16-16h32c8.84 0 16 7.16 16 16v16h128v-82.75c0-8.48-3.37-16.62-9.37-22.62zM320 160H192V96h128v64zm64 208c0 8.84-7.16 16-16 16h-32c-8.84 0-16-7.16-16-16v-16H192v16c0 8.84-7.16 16-16 16h-32c-8.84 0-16-7.16-16-16v-16H0v96c0 17.67 14.33 32 32 32h448c17.67 0 32-14.33 32-32v-96H384v16z"}]])

(defn question
  [color]
  [:svg.svg-inline--fa.fa-tasks.fa-w-16
   {:aria-hidden "true" :focusable "false" :data-prefix "fas" :data-icon "tasks" :role "img" :xmlns "http://www.w3.org/2000/svg" :viewBox view-box}
   [:path {:fill color :d "M139.61 35.5a12 12 0 0 0-17 0L58.93 98.81l-22.7-22.12a12 12 0 0 0-17 0L3.53 92.41a12 12 0 0 0 0 17l47.59 47.4a12.78 12.78 0 0 0 17.61 0l15.59-15.62L156.52 69a12.09 12.09 0 0 0 .09-17zm0 159.19a12 12 0 0 0-17 0l-63.68 63.72-22.7-22.1a12 12 0 0 0-17 0L3.53 252a12 12 0 0 0 0 17L51 316.5a12.77 12.77 0 0 0 17.6 0l15.7-15.69 72.2-72.22a12 12 0 0 0 .09-16.9zM64 368c-26.49 0-48.59 21.5-48.59 48S37.53 464 64 464a48 48 0 0 0 0-96zm432 16H208a16 16 0 0 0-16 16v32a16 16 0 0 0 16 16h288a16 16 0 0 0 16-16v-32a16 16 0 0 0-16-16zm0-320H208a16 16 0 0 0-16 16v32a16 16 0 0 0 16 16h288a16 16 0 0 0 16-16V80a16 16 0 0 0-16-16zm0 160H208a16 16 0 0 0-16 16v32a16 16 0 0 0 16 16h288a16 16 0 0 0 16-16v-32a16 16 0 0 0-16-16z"}]])

(defn paper
  [color]
  [:svg.svg-inline--fa.fa-paperclip.fa-w-16
   {:aria-hidden "true" :focusable "false" :data-prefix "fas" :data-icon "paperclip" :role "img" :xmlns "http://www.w3.org/2000/svg" :viewBox view-box}
   [:path {:fill color :d "M43.246 466.142c-58.43-60.289-57.341-157.511 1.386-217.581L254.392 34c44.316-45.332 116.351-45.336 160.671 0 43.89 44.894 43.943 117.329 0 162.276L232.214 383.128c-29.855 30.537-78.633 30.111-107.982-.998-28.275-29.97-27.368-77.473 1.452-106.953l143.743-146.835c6.182-6.314 16.312-6.422 22.626-.241l22.861 22.379c6.315 6.182 6.422 16.312.241 22.626L171.427 319.927c-4.932 5.045-5.236 13.428-.648 18.292 4.372 4.634 11.245 4.711 15.688.165l182.849-186.851c19.613-20.062 19.613-52.725-.011-72.798-19.189-19.627-49.957-19.637-69.154 0L90.39 293.295c-34.763 35.56-35.299 93.12-1.191 128.313 34.01 35.093 88.985 35.137 123.058.286l172.06-175.999c6.177-6.319 16.307-6.433 22.626-.256l22.877 22.364c6.319 6.177 6.434 16.307.256 22.626l-172.06 175.998c-59.576 60.938-155.943 60.216-214.77-.485z"}]])

(defn podcast
  [color]
  [:svg.svg-inline--fa.fa-volume-up.fa-w-16
   {:aria-hidden "true" :focusable "false" :data-prefix "fas" :data-icon "volume-up" :role "img" :xmlns "http://www.w3.org/2000/svg" :viewBox view-box}
   [:path {:fill color :d "M215.03 71.05L126.06 160H24c-13.26 0-24 10.74-24 24v144c0 13.25 10.74 24 24 24h102.06l88.97 88.95c15.03 15.03 40.97 4.47 40.97-16.97V88.02c0-21.46-25.96-31.98-40.97-16.97zm233.32-51.08c-11.17-7.33-26.18-4.24-33.51 6.95-7.34 11.17-4.22 26.18 6.95 33.51 66.27 43.49 105.82 116.6 105.82 195.58 0 78.98-39.55 152.09-105.82 195.58-11.17 7.32-14.29 22.34-6.95 33.5 7.04 10.71 21.93 14.56 33.51 6.95C528.27 439.58 576 351.33 576 256S528.27 72.43 448.35 19.97zM480 256c0-63.53-32.06-121.94-85.77-156.24-11.19-7.14-26.03-3.82-33.12 7.46s-3.78 26.21 7.41 33.36C408.27 165.97 432 209.11 432 256s-23.73 90.03-63.48 115.42c-11.19 7.14-14.5 22.07-7.41 33.36 6.51 10.36 21.12 15.14 33.12 7.46C447.94 377.94 480 319.54 480 256zm-141.77-76.87c-11.58-6.33-26.19-2.16-32.61 9.45-6.39 11.61-2.16 26.2 9.45 32.61C327.98 228.28 336 241.63 336 256c0 14.38-8.02 27.72-20.92 34.81-11.61 6.41-15.84 21-9.45 32.61 6.43 11.66 21.05 15.8 32.61 9.45 28.23-15.55 45.77-45 45.77-76.88s-17.54-61.32-45.78-76.86z"}]])

(defn virtual-reality
  [color]
  [:svg.svg-inline--fa.fa-vr-cardboard.fa-w-16
   {:aria-hidden "true" :focusable "false" :data-prefix "fas" :data-icon "vr-cardboard" :role "img" :xmlns "http://www.w3.org/2000/svg" :viewBox view-box}
   [:path {:fill color :d "M608 64H32C14.33 64 0 78.33 0 96v320c0 17.67 14.33 32 32 32h160.22c25.19 0 48.03-14.77 58.36-37.74l27.74-61.64C286.21 331.08 302.35 320 320 320s33.79 11.08 41.68 28.62l27.74 61.64C399.75 433.23 422.6 448 447.78 448H608c17.67 0 32-14.33 32-32V96c0-17.67-14.33-32-32-32zM160 304c-35.35 0-64-28.65-64-64s28.65-64 64-64 64 28.65 64 64-28.65 64-64 64zm320 0c-35.35 0-64-28.65-64-64s28.65-64 64-64 64 28.65 64 64-28.65 64-64 64z"}]])

(def _history (r/atom []))
;; Stores the clicked node to cookie (as history)
(defn history [x]
  (if (rc/contains-val? x) (.alert js/window (str x " Already exists"))
      ((println x)
       (set! js/document.cookie (str x "=" x))
       (let [p (str (rc/get :direction) "_" x)]
         ((rc/set! :direction p)
          
          (reset! _history (str/split p "_"))
          (rc/set! :id (str x)))))))

;; Make Translations both node and graph
(defn translate [x]
  ((println x)
   (set! (.-translate (.-style (.getElementById js/document (str x)))) "600px 150px")
   (el/set-attribute (.getElementById js/document "learning-journey-graph-container-zoomable") "transform" "translate(0, 0)")
   (history x)))

;; Handler for the node click
(defn manipulatNode [x]
  (translate x))

;; Center the last clicked node on startup
  (defn center []
    (if (empty? (str (rc/get :id))) (set! js/document.cookie (str "id=")) (let [x (str (rc/get :id))]
        (set! (.-translate (.-style (.getElementById js/document x))) "600px 150px")))
     )


;; (defn test []
(def some-package
  {:space/points     [[0.00015381353970574948 0.9996004163661126 0.00024577009418162043]
                      [0.010722645658898728 0.9721442356409847 0.01713311870011647]
                      [0.0002667450424126699 0.7125060948284871 0.28722716012910016]
                      [0.00017202057125193456 0.9995531173322211 0.0002748620965270185]
                      [0.00017592514626605667 0.9995429738541117 0.0002811009996222583]
                      [0.0002321265094631036 0.999396971460703 0.00037090202983388774]
                      [0.16444439123952642 0.8353114537846592 0.00024415497581436]
                      [0.0001305043339665557 0.9996609700543647 0.00020852561166870493]
                      [0.0002936997162002844 0.9992370138539461 0.0004692864298536192]
                      [0.0001872597559822072 0.9995135283023889 0.00029921194162892026]
                      [0.00012291560811909566 0.9996806843828725 0.00019640000900838828]
                      [0.00009721915928371727 0.9997474397570957 0.00015534108362063798]
                      [0.9998478043123853 0.0001132584446555803 0.000038937242959131705]
                      [0.9330310370386107 0.04983584426127282 0.01713311870011647]
                      [0.09481345618086846 0.9047961551871851 0.0003903886319464337]
                      [0.019899283938243462 0.9483047578060342 0.031795958255722345]
                      [0.00041396457692936155 0.0019239910411862095 0.9976620443818844]
                      [0.0001312409454665088 0.9996590564523472 0.0002097026021863477]
                      [0.00011501178964001832 0.9997012172729907 0.00018377093736935454]
                      [0.9330310370386107 0.04983584426127282 0.01713311870011647]
                      [0.000046580982340747305 0.00021649531797631017 0.9997369236996829]
                      [0.00019676786348392627 0.99948882771911 0.00031440441740612985]
                      [0.00011444569890526993 0.4828902173182024 0.5169953369828922]
                      [0.00022109057327128497 0.38136969038463203 0.6184092190420968]
                      [0.00016951240638521544 0.9995596331541295 0.0002708544394852792]],
   :space/point-nodes
                     {0
                      {:node/uuid #uuid "38f499be-b243-4888-812a-dbdd1be206c9",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-violet.svg",
                       :ui/color  "violet"},
                      1
                      {:node/uuid #uuid "0186fd9a-9ace-4747-9931-c374e68f6b0a",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-violet.svg",
                       :ui/color  "violet"},
                      2
                      {:node/uuid #uuid "35dc8148-1dc6-4893-acbe-c038f7152be7",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-violet.svg",
                       :ui/color  "violet"},
                      3
                      {:node/uuid #uuid "79911fa6-704b-49c3-8973-e3a66e685f07",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-violet.svg",
                       :ui/color  "violet"},
                      4
                      {:node/uuid #uuid "c916dc7d-0c75-4d3f-a091-4afa9bf208dc",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-violet.svg",
                       :ui/color  "violet"},
                      5
                      {:node/uuid #uuid "22a0d3d2-5c2d-4c79-b96e-b19fa43d8892",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-violet.svg",
                       :ui/color  "violet"},
                      6
                      {:node/uuid #uuid "54febc39-bd90-4e90-9bf9-ebb41a169937",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-violet.svg",
                       :ui/color  "violet"},
                      7
                      {:node/uuid #uuid "717acb6c-6891-4a50-accd-3148a274ad5f",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-violet.svg",
                       :ui/color  "violet"},
                      8
                      {:node/uuid #uuid "48e7949d-dece-492e-87e7-6ae5ddd5f4dd",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-violet.svg",
                       :ui/color  "violet"},
                      9
                      {:node/uuid #uuid "a59efd3c-c5a5-45c6-836f-26576c326d46",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-violet.svg",
                       :ui/color  "violet"},
                      10
                      {:node/uuid #uuid "7d66ed4a-6be2-4532-a98a-aea13c8179f5",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-violet.svg",
                       :ui/color  "violet"},
                      11
                      {:node/uuid #uuid "765e78fc-353a-4167-b764-fa854d1b9871",
                       :node/kind :product,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/products-violet.svg",
                       :ui/color  "violet"},
                      12
                      {:node/uuid #uuid "5a4c6f87-4a32-4eb4-8bc7-e704df7b98c6",
                       :node/kind :podcast,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/podcasts-orange.svg",
                       :ui/color  "orange"},
                      13
                      {:node/uuid #uuid "1b998a67-bf9e-456b-a71d-07597c15f301",
                       :node/kind :question,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/assessments-orange.svg",
                       :ui/color  "orange"},
                      14
                      {:node/uuid #uuid "1ca51ffb-fbe6-4b6e-9c36-50f09566f150",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-violet.svg",
                       :ui/color  "violet"},
                      15
                      {:node/uuid #uuid "5bccee52-c9d4-4c64-8dbe-c15b689d90d8",
                       :node/kind :virtual-reality,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/virtual-reality.svg",
                       :ui/color  "violet"},
                      16
                      {:node/uuid #uuid "fe270da6-4cbb-470c-b8cb-a759d12ac606",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-blue.svg",
                       :ui/color  "blue"},
                      17
                      {:node/uuid #uuid "dc98559b-72b4-4012-853e-b34532a40cda",
                       :node/kind :paper,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/papers-violet.svg",
                       :ui/color  "violet"},
                      18
                      {:node/uuid #uuid "fc171d42-1b58-44c9-aec9-565ce189f3e0",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-violet.svg",
                       :ui/color  "violet"},
                      19
                      {:node/uuid #uuid "5d69d3ce-9618-43ff-a441-c360a1ae6b06",
                       :node/kind :question,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/assessments-orange.svg",
                       :ui/color  "orange"},
                      20
                      {:node/uuid #uuid "6c445e99-adf4-4a2f-94b4-fc844584d525",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-blue.svg",
                       :ui/color  "blue"},
                      21
                      {:node/uuid #uuid "365d5f30-1114-4be0-89c9-41edad4f280a",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-violet.svg",
                       :ui/color  "violet"},
                      22
                      {:node/uuid #uuid "159d6b9e-29a5-4035-936a-2d7e8be07c2f",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-blue.svg",
                       :ui/color  "blue"},
                      23
                      {:node/uuid #uuid "e3b56eaa-04ae-4767-9259-28d268bd5ce4",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-blue.svg",
                       :ui/color  "blue"},
                      24
                      {:node/uuid #uuid "6fe5134a-ed45-424b-9438-e3bfb378ff81",
                       :node/kind :document,
                       :ui/svg
                                  "https://s3-eu-west-1.amazonaws.com/cdn-dev.obrizum/assets/images/documents-violet.svg",
                       :ui/color  "violet"}},
   :space/trajectory '(12),
   :concepts         '({:node/uuid     #uuid "41ffc71a-b598-46fc-a848-04d91a5601e8",
                        :concept/key   :patients-surgery-people-testing-frailty,
                        :text/tran     {:lang/en "patients-surgery-people-testing-frailty"},
                        :concept/color "orange"}
                       {:node/uuid     #uuid "41ffc71a-b598-46fc-a848-04d91a5601e8",
                        :concept/key   :emotion-code-healing-love-trapped,
                        :text/tran     {:lang/en "emotion-code-healing-love-trapped"},
                        :concept/color "violet"}
                       {:node/uuid     #uuid "41ffc71a-b598-46fc-a848-04d91a5601e8",
                        :concept/key   :region-availability-target-vms-zones,
                        :text/tran     {:lang/en "region-availability-target-vms-zones"},
                        :concept/color "blue"}),
   :space/embedding
                     [[-13.930245449202467 4.658922145744597]
                      [-15.966975079867517 0.9456673616491622]
                      [-13.738107683370552 0.06047214480162614]
                      [-12.026982908168902 4.222501762984486]
                      [-13.566725868056903 3.1099877483143423]
                      [-11.752772418814624 1.9203985175385367]
                      [-13.069740204453016 0.8574218760816698]
                      [-15.264385671898236 4.480193796855846]
                      [-12.25506725152238 2.4616938933467947]
                      [-13.255360020220069 2.2758479315514126]
                      [-16.397720827442257 4.08058378458796]
                      [-15.503948504179593 2.8271175529122643]
                      [-11.733494214556107 -1.2959626507277395]
                      [-11.838128995077755 0.24516756033217163]
                      [-14.135350784379666 1.1405264812945561]
                      [-14.950868209577655 1.7307205453719672]
                      [-14.371951678761635 -1.3691201666395119]
                      [-14.876452955047226 3.488241143850665]
                      [-16.554412039087488 2.8441034367494584]
                      [-12.692803945064753 -0.6191163743050418]
                      [-13.819864864674233 -1.9430158609187742]
                      [-12.645849251501648 3.3423290344573355]
                      [-14.807680025913376 -0.2652954444184227]
                      [-15.526371479668782 -1.0923604487017324]
                      [-13.332617516524573 4.710417366076038]]})

(def some-route
  {:parameters  {:query {:space/uuid #uuid"9482933f-5a3a-4f5d-98f1-f0a7e0696d21"}}
   :path-params {:org "cbs"}})

;; The Graph 
(defn graph-2d
  []
  (let [width "100%"
        height "500px"
        {:space/keys [point-nodes trajectory embedding]} some-package
        nodes embedding
        data {:nodes (map-indexed
                       (fn [i [cx cy]]
                         (let [{:keys [ui/color node/kind]} (get point-nodes i)]
                           {:id            i
                            :x             (* 100 cx)
                            :y             (* 100 cy)
                            :viewGenerator (fn [_props]
                                             (let [factory (case kind
                                                             :document document
                                                             :video video
                                                             :product product
                                                             :question question
                                                             :open-question question
                                                             :paper paper
                                                             :podcast podcast
                                                             :virtual-reality virtual-reality
                                                             document)]
                                               (r/as-element (factory color))))}))
                       nodes)
              :links (-> trajectory link-pairs links)}]
    [:div
     [:div {:style {:border "1px solid black"
                   :on-click center
                   :margin "10px"}}
     
     [graph {:id            "learning-journey"

             :data          data
             :config        {:node-highlight-behavior true
                             :static-graph            true
                             :directed                true
                             :background-color        "black"
                             :width                   width
                             :height                  height
                             :node                    {:color                  "#9300ee"
                                                       :size                   160
                                                       :highlight-stroke-color "lightgray"
                                                       :render-label           true}
                             :link                    {:highlight-color "lightblue"
                                                       :stroke-width    2}}
             :on-click-node manipulatNode}]]
     
      [:div {:style {:width "40%"
                 :height "100vh"
                 :border "1px solid red"
                 :z-index "100000"
                  :margin "0"
                  :margin-right "10px"
                  :float "right"}}
      [:ul {:style{:list-style "none"}
            :id "history"}
            (for [x (range (count (rest @_history)))]
              [:li {:style {:font-size "23px"
                             :font-color "red"}}
                (str "Step " (inc x) ": " (nth @_history (inc x)) " was clicked!")])
        
       ]
    [:br]
     ]]
    ))


(defn main-panel []
  [graph-2d])

;; Helps to synchronize the cookie with the atom state at startup
(defn write-to-atom []
  (let [p (str (rc/get :direction))]
         ((reset! _history (str/split (str p) "_"))
          (.log js/console @_history))))