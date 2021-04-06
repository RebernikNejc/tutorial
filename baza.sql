CREATE TABLE "tutorial" (
  "id" SERIAL PRIMARY KEY,
  "name" varchar
);

CREATE TABLE "page" (
  "id" SERIAL PRIMARY KEY,
  "tutorial" int,
  "position" int,
  "image" varchar,
  "status" int
);

CREATE TABLE "hints" (
  "id" SERIAL PRIMARY KEY,
  "page" int,
  "position" int,
  "mode" int,
  "ref" varchar,
  "x" int,
  "y" int,
  "content" varchar,
  "placement" varchar,
  "status" int
);

ALTER TABLE "page" ADD FOREIGN KEY ("tutorial") REFERENCES "tutorial" ("id");

ALTER TABLE "hints" ADD FOREIGN KEY ("page") REFERENCES "page" ("id");

COMMENT ON COLUMN "page"."position" IS 'for ordering';

COMMENT ON COLUMN "page"."image" IS 'uuid on AWS for image';

COMMENT ON COLUMN "hints"."position" IS 'for ordering';

COMMENT ON COLUMN "hints"."mode" IS '0 for ref, 1 for xy coordinates';

COMMENT ON COLUMN "hints"."placement" IS 'top, bottom, left, right, center or auto';
